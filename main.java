import java.util.*;

public class main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args){

        Album album = new Album("Album_1", "AP Dhillon");
        album.addSong("Brown Munde", 3.53);
        album.addSong("Excuses", 4.2);
        album.addSong("Insane", 3.4);
        album.addSong("Desires", 4.0);
        albums.add(album);
        album = new Album("Album_2","King");
        album.addSong("Shammein", 4.0);
        album.addSong("Tu aake dekhle", 5.2);
        album.addSong("Iiconic", 3.5);
        albums.add(album);

        LinkedList<Song> p_1 = new LinkedList<>();
        albums.get(0).addToPL("Insane", p_1);
        albums.get(1).addToPL("Shammein", p_1);
        albums.get(1).addToPL("Iiconic", p_1);
        albums.get(0).addToPL("Excuses", p_1);

        play(p_1);

    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("Current playlist has no song");
        }
        else{
            System.out.println("Now Playing"+ listIterator.next().toString());
            showMenu();
        }

        while(!quit){
            int user_action = sc.nextInt();
            sc.nextLine();

            switch(user_action){
                case 0 :
                    System.out.println("Playlist added");
                    quit = true;
                    break;
                case 1 :
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }
                    else{
                        System.out.println("Reached to the End!");
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }
                    else{
                        System.out.println("Can't play previous song: 1st song!");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at start of list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("Reached at end");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5 :
                    showMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                            
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing "+ listIterator.previous().toString());
                            }
                        }
                    }
            }
        }

    }
    
    private static void showMenu(){
        System.out.println("Available\n press");
        System.out.println("0- to esc");
        System.out.println("1- to play next song");
        System.out.println("2- to play previous song");
        System.out.println("3- to replay");
        System.out.println("4- Show list of songs");
        System.out.println("5- show all options");
        System.out.println("6- to delete current song");
    }
    
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("<--------------------->");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("<--------------------->");

    }
}
