package AmazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/*
Input:
userSongs = {
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
songGenres = {
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

Output: {
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}
 */
public class favoriteGenresTest {

    @Test
    public void getFavoriteGenresTest(){
        Map<String,List<String>> userMap = new HashMap<String, List<String>>();
        String[] strList = new String[]{"song1", "song2", "song3", "song4", "song8"};
        userMap.put("David",java.util.Arrays.asList(strList));

        String[] emmaList = new String[]{"song5", "song6", "song7"};
        userMap.put("Emma", Arrays.asList(emmaList));

        Map<String,List<String>> genreMap = new HashMap<String, List<String>>();
        String[] rocklist = new String[]{"song1", "song3"};
        genreMap.put("Rock",java.util.Arrays.asList(rocklist));

        String[] dubStepList = new String[]{"song7"};
        genreMap.put("Dubstep", Arrays.asList(dubStepList));

        String[] TechnoList = new String[]{"song2","song4"};
        genreMap.put("Techno", Arrays.asList(TechnoList));

        String[] popList = new String[]{"song5","song6"};
        genreMap.put("Pop", Arrays.asList(popList));

        String[] jazzList = new String[]{"song8","song9"};
        genreMap.put("Jazz", Arrays.asList(jazzList));

        FavoriteGenres fg = new FavoriteGenres();
        Map<String,List<String>> result = fg.getFvoriteGenres(userMap,genreMap);

        Assert.assertEquals(2,result.get("David").size());
        Assert.assertEquals(1,result.get("Emma").size());



    }
}
