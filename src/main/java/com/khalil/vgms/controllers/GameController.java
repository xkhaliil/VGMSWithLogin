package com.khalil.vgms.controllers;

import com.khalil.vgms.entities.Game;
import com.khalil.vgms.entities.Genre;
import com.khalil.vgms.services.GameService;
import com.khalil.vgms.services.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    GenreService genreService;

    @RequestMapping("showCreate")
    public String showCreate(ModelMap modelMap) {
        List<Genre> genres = genreService.getAllGenres();
        Game game = new Game();
        Genre genre = new Genre();
        genre = genres.get(0);
        game.setGenre(genre);
        modelMap.addAttribute("game", game);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("genre", genre);
        modelMap.addAttribute("genres", genres);
        modelMap.addAttribute("page",0);
        return "formGame";
    }

    @RequestMapping("/saveGame")
    public String saveGame(@Valid Game game,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
    ModelMap    modelMap,
    @ModelAttribute("page") int pageFromPrevious,
    @RequestParam(name = "size", defaultValue = "2") int size) {
        int page;
        if (bindingResult.hasErrors())
        {
            List<Genre> genres = genreService.getAllGenres();
            modelMap.addAttribute("genres", genres);
            modelMap.addAttribute("mode", "update");
            return "formGame";
        }

        if (game.getGameId() == null) {
            page = gameService.getAllGames().size() / size;
        } else {
            page = pageFromPrevious;
        }
        gameService.saveGame(game);
        redirectAttributes.addAttribute("page", page);
        return "redirect:/gamesList";
    }

    @RequestMapping("/gamesList")
    public String gamesList(
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        Page<Game> games = gameService.getAllGamesByPage(page, size);
        modelMap.addAttribute("games", games);
        modelMap.addAttribute("pages", new int[games.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listGames";
    }

    @RequestMapping("/deleteGame")
    public String deleteGame(
            @RequestParam("gameId") Long gameId,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    ) {
        gameService.deleteGameById(gameId);
        Page<Game> games = gameService.getAllGamesByPage(page, size);
        modelMap.addAttribute("games", games);
        modelMap.addAttribute("pages", new int[games.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listGames";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("gameId") Long gameId, ModelMap modelMap, @RequestParam(name = "page") int page) {
        List<Genre> genres = genreService.getAllGenres();
        Game game = gameService.getGame(gameId);
        modelMap.addAttribute("game", game);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("genres", genres);
        modelMap.addAttribute("mode", "update");
        return "formGame";
    }

    @RequestMapping("/updateGame")
    public String updateGame(
            @ModelAttribute("game") @Valid Game game,
            BindingResult bindingResult,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            RedirectAttributes redirectAttributes
    ) {
        if (!bindingResult.hasErrors()) {
            gameService.updateGame(game);
            redirectAttributes.addAttribute("page", page);
        }
        return "redirect:/gamesList";
    }
}
