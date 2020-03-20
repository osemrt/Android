package ce.yildiz.edu.tr.recyclerview.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ce.yildiz.edu.tr.recyclerview.models.Monster;
import ce.yildiz.edu.tr.recyclerview.repositories.MonsterRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Monster>> monsters;
    private MonsterRepository monsterRepository;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void init(){
        if(monsters!=null){
            return;
        }

        monsterRepository = MonsterRepository.getInstance();
        monsters = monsterRepository.getMonsters();
    }

    public void addNewValue(final Monster monster){
        isUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Monster> currentMonsters = monsters.getValue();
                currentMonsters.add(monster);
                monsters.postValue(currentMonsters);
                isUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

    }

    public MutableLiveData<List<Monster>> getMonsters() {
        return monsters;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
