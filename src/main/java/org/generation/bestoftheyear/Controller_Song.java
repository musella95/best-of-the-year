package org.generation.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class Controller_Song {
    private List<Song> getSongs(){
        List<Song> songs =new ArrayList<>();
        songs.add(new Song(1,"amore amaro","Gigi Finizio"));
        songs.add(new Song(2,"tu scendi","Stelle"));
        songs.add(new Song(3,"Cane","Anubi"));
        songs.add(new Song(4,"Mailae","Goddamm"));
        return songs;
    }
    @GetMapping
    public String showSongs(Model model) {
        List<Song> songs = getSongs();
        model.addAttribute("songs", songs);
        return "song_list";
    }
    private Song getSongById (int songId) {
        Song song = null;
        for (Song s: getSongs()) {
            if (s.getId()==songId){
                song = s;
                break;
            }
        }
        return song;
    }
    @GetMapping("/details")
    public String songDetails (@RequestParam int songId, Model model){
        Song song = getSongById(songId);
        model.addAttribute("song", song);
        return "song_details";
    }
}
