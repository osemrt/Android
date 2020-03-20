package ce.yildiz.edu.tr.recyclerview.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ce.yildiz.edu.tr.recyclerview.models.Monster;

/**
 * Singleton pattern
 */

public class MonsterRepository {

    private static MonsterRepository instance;
    private ArrayList<Monster> dataSet = new ArrayList<>();

    public static MonsterRepository getInstance() {
        if (instance == null) {
            instance = new MonsterRepository();
        }
        return instance;
    }

    //Pretend to get data from a webservice or online source
    public MutableLiveData<List<Monster>> getMonsters(){
        setMonsters();
        MutableLiveData<List<Monster>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setMonsters() {
        dataSet.add(
                new Monster("Hodag",
                        "a mythical animal reported chiefly from Wisconsin and Minnesota, noted for its ugliness, lateral horns, and hooked tail, and reputed to be outstanding in both ferocity and melancholy",
                        "https://i.ya-webdesign.com/images/monster-cartoon-png-3.png")
        );
        dataSet.add(
                new Monster("Dybbuk",
                        "an evil spirit or the wandering soul of a dead person believed in Jewish folklore to enter and control a living body until exorcised by a religious rite",
                        "https://i.ya-webdesign.com/images/monster-cartoon-png-6.png")
        );
        dataSet.add(
                new Monster("Sasquatch",
                        "a hairy creature like a human being that is reported to exist in the northwestern U.S. and western Canada and is said to be a primate between 6 and 15 feet (1.8 and 4.6 meters) tall — called also bigfoot",
                        "https://ya-webdesign.com/transparent250_/vector-monster-little-2.png")
        );
        dataSet.add(
                new Monster("Nix",
                        "a supernatural creature originally in Germanic folklore and conceived of in many forms but usually as having the form of a woman or as half human and half fish, dwelling in fresh water usually in a beautiful palace, and usually unfriendly to man",
                        "https://ya-webdesign.com/transparent250_/monsters-clip-art-2.png")
        );
        dataSet.add(
                new Monster("Guytrash",
                        "a specter or ghost especially in the form of an animal",
                        "https://ya-webdesign.com/transparent250_/monster-clipart-cartoon.png")
        );
        dataSet.add(
                new Monster("Wyvern",
                        "a fabulous animal usually represented as a 2-legged winged creature resembling a dragon",
                        "https://ya-webdesign.com/transparent250_/monster-clipart-cartoon-3.png")
        );
        dataSet.add(
                new Monster("Windigo",
                        "a three-headed dog that in Greek mythology guards the entrance to Hades",
                        "https://ya-webdesign.com/transparent250_/evaluation-clipart-discovery-16.png")
        );
        dataSet.add(
                new Monster("Kraken",
                        "a cannibalistic creature of Algonquian mythology believed to have been a lost hunter forced by hunger to eat human flesh and thereafter to have become a crazed man-eating ogre roaming the forest",
                        "https://ya-webdesign.com/transparent250_/monster-clipart-christmas-13.png")
        );
        dataSet.add(
                new Monster("Snallygaster",
                        "a fabulous Scandinavian sea monster perhaps imagined on the basis of chance sightings of giant squids",
                        "https://ya-webdesign.com/transparent250_/7-clipart-cartoon-13.png")
        );
        dataSet.add(
                new Monster("Werewolf",
                        "a grotesque creature that drinks the blood of livestock and is reported to exist in North and South America",
                        "https://ya-webdesign.com/transparent250_/cartoon-monster-png-1.png")
        );
        dataSet.add(
                new Monster("Tommy-knocker",
                        "a mythical nocturnal creature that is reported chiefly from rural Maryland, is reputed to be part reptile and part bird, and is said to prey on poultry and children",
                        "https://ya-webdesign.com/transparent250_/vector-monster-creature-3.png")
        );
        dataSet.add(
                new Monster("Windigo",
                        "a person transformed temporarily or permanently into a wolf or capable of assuming a wolf\\'s form",
                        "https://ya-webdesign.com/transparent250_/dojo-clipart-4.png")
        );


    }

}
