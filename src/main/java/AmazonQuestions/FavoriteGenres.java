package AmazonQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {

    public Map<String,List<String>> getFvoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap){
        Map<String,List<String>> result = new HashMap<String, List<String>>();

        if(userMap == null || genreMap == null || userMap.size() == 0 || genreMap.size() == 0)
            return result;

        Map<String,String> songToGenre = new HashMap<String, String>();
        for(String genre : genreMap.keySet()){
            List<String> songList = genreMap.get(genre);
            for(String song : songList) {
                if (!songToGenre.containsKey(song))
                    songToGenre.put(song, genre);
            }
        }

        Map<String,Map<String,Integer>> userGenreCount = new HashMap<String, Map<String, Integer>>();

        for(String user : userMap.keySet()){
            List<String> userSongList = userMap.get(user);
            if(!userGenreCount.containsKey(user)) {
                userGenreCount.put(user, new HashMap<String, Integer>());
            }
                for(String userSong : userSongList){
                String songGenre = songToGenre.get(userSong);
                Map<String,Integer> songCountMap = userGenreCount.get(user);
                if(!songCountMap.containsKey(songGenre)){
                    songCountMap.put(songGenre,1);
                }
                else{
                    Integer num = songCountMap.get(songGenre);
                    songCountMap.put(songGenre,num+1);
                }
            }
        }


        for(String user:userGenreCount.keySet()){
            if(!result.containsKey(user)){
                result.put(user, new ArrayList<String>());
            }

            List<String> userGenerList = result.get(user);
            int genreCount = 0;
            Map<String,Integer> genreCountMap = userGenreCount.get(user);

            for(String genre : genreCountMap.keySet()){
                if(genreCountMap.get(genre) > genreCount){
                   userGenerList.clear();
                   userGenerList.add(genre);
                   genreCount = genreCountMap.get(genre);
                }
                else if(genreCountMap.get(genre) == genreCount)
                    userGenerList.add(genre);
                else
                    continue;
            }
        }

        return result;
    }
}
