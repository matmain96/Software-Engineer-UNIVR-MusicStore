package Model;
import javax.swing.ImageIcon;

public class CD {
	private String CDname;
	private int code;
	private String Trackname;
	private String genre;
	private int dim;
	private int price;
	private String release; 
	private String band;
	private ImageIcon pic;
	private String info;
	private Object[] String;
	
	public CD(String CDname, int code, String Trackname, String genre, int price,String info, String release, String band, ImageIcon image ){
		this.CDname=CDname;
		this.code=code;
		this.Trackname = Trackname;
		this.info=info;
		this.price=price; 
		this.release=release;
		this.band=band;
		this.pic=image;
		this.genre=genre;
		this.info=info;
	}

	public ImageIcon getPic() {
		return pic;
	}

	public String getCDname() {
		return CDname;
	}


	public int getCode() {
		return code;
	}

	public String getTrackname() {
		return Trackname;
	}



	public String getGenre() {
		return genre;
	}



	public int getDim() {
		return dim;
	}

	public int getPrice() {
		return price;
	}

	public String getRelease() {
		return release;
	}



	public String getBand() {
		return band;
	}


	public String Tracks(){
		
		String[] result=Trackname.split(",");
		String tracks="";
		for(int i=0; i<result.length;i++)
			tracks+=(i+1)+ ".  "+result[i]+"\n";
		
		
		return tracks;
		
	}



}
