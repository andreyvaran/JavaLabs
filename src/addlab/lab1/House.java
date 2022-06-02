package addlab.lab1;

import java.util.*;

public class House {

    private ArrayList<Flat> allflats;

    public House() {
        allflats = new ArrayList<Flat>();
    }
    public House(ArrayList<Flat> flats) {
        this.allflats = flats;
    }

    public void  addFlat(Flat flat ){
        this.allflats.add(flat);
    }

    public void addFlats(ArrayList<Flat> flt){
        for (Flat f:flt) {
            this.allflats.add(f);

        }
    }

    public Map getInfo(){
        Map info_map = new HashMap();

        for (Flat f:this.allflats
             ) {
            if (info_map.containsKey(f.getRooms())) {
                info_map.put(f.getRooms(), (int)info_map.get(f.getRooms()) + 1);
            }
            else{
                info_map.put(f.getRooms() , 1);
            }

        }
        return info_map;
    }
    public List<Flat> getGreatestInAreaFlats(int flats){
        allflats.sort(new FlatAreaComparator());
        System.out.println(allflats);
        Collections.reverse(allflats);

        return flats < allflats.size() ? allflats.subList(0 ,flats) : allflats;

    }

    public  int getCountFlats(){
        return this.allflats.size();
    }

    @Override
    public String toString() {
        return "House{" +
                "flats=" + allflats +
                '}';
    }
}
