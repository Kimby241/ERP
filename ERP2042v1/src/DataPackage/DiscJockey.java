package DataPackage;


import DataPackage.ProcessusComponent;

public class DiscJockey{
	
    ProcessusComponent processusList;
	
    // newSongList contains every Song, SongGroup,
    // and any Songs saved in SongGroups
	
    public DiscJockey(ProcessusComponent newProcessusList){
	processusList = newProcessusList;
    }
	
    // Calls the displaySongInfo() on every Song
    // or SongGroup stored in songList
	
    public void getProcessusList(){
	processusList.displayProcessusInfo();
    }
	
}
