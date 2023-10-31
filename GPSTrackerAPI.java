package gov.nasa.worldwindx.examples;

import com.jogamp.nativewindow.CapabilitiesFilter.Test;
import gov.nasa. worldwind. avlist.AVKey; 
import gov.nasa.worldwind.event.*;
import gov.nasa.worldwind.formats.gpx.GpxReader;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.MarkerLayer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.pick.PickedObject;
import gov.nasa.worldwind.render.Balloon;
import gov.nasa.worldwind.render.BalloonAttributes;
import gov.nasa.worldwind.render.BasicBalloonAttributes;
import gov.nasa.worldwind.render.Material;
import gov.nasa.worldwind.render.Offset;
import gov.nasa.worldwind.render.ScreenAnnotationBalloon;
import gov.nasa.worldwind. render.Size;
import gov.nasa.worldwind.render.markers.*;
import gov.nasa.worldwind.util.WWIO;
import gov.nasa.worldwind.util.WWUtil; 
import static gov.nasa.worldwindx.examples.ApplicationTemplate.insertBeforeCompass;
import static gov.nasa.worldwindx.examples.ApplicationTemplate.insertBeforePlacenames;
import gov.nasa.worldwindx.examples.util.BalloonController;
import gov.nasa.worldwindx.examples.util. HotSpotController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java. io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
• This is a modification of the GPSTracker.java file which allows the coordinates obtained through using the MATLABS
* application and API to display dynamically on the globe tracker.
* */




public class GPSTracksAPI extends ApplicationTemplate{
	protected static final String TRACK_PATH = "gov/nasa/worldwindx/examples/data/tuolumne.gpx";
	
	protected static class AppFrame extends ApplicationTemplate.AppFrame{
	protected HotSpotController hotSpotController;
	protected BalloonController balloonController;
	protected RenderableLayer layer;

	public AppFrame() throws IOException {
		super (true, true, false);
		// Add a controller to send input events to BrowserBalloons.
		this.hotSpotController = new HotSpotController (this.getWwd());
		// Add a controller to handle link and navigation events in BrowserBalloons
		this.balloonController = new BalloonController(this. getWwd());
		// Create a layer to display the balloons.
		this.layer = new RenderableLayer();
		this.layer.setName("Beacons");
		insertBeforePlacenames(getWwd(), this.layer);
		// Add an AnnotationBalloon and a BrowserBalloon to the balloon layer.
		// this. makeBrowserBalloon ();
		// Size the WorldWindow to provide enough screen space for the BrowserBalloon, and center the Wor
		// on the screen.
		Dimension size = new Dimension (1200, 800);
		this.setPreferredSize(size);
		this.pack();
		WWUtil.alignComponent(null, this, AVKey.CENTER);
		this.makeAnnotationBalloon();
		this.enableNAIPLayer();
		try (FileWriter writer = new FileWriter ("C:\\Users\\5G_Server\\Desktop\\Apple.txt")) {
			String valuel20 = reverseTheOrderOfWords(URLReader());
			writer.write(valuel20);
		}
		catch (IOException e) {
			// Handle the exception
		}
		new java.util.Timer().schedule(
		new java.util.TimerTask() { 
		@override
		public void run() {
			try {
			LoopFunction();
			while(true) {
			TimeUnit.SECONDS.sleep(1);
			new java.util.Timer().schedule(
			new java.util.TimerTask() {
				@Override
				public void run () {
				try {
				// AppleReader();
				try(FileWriter writer = new FileWriter ("C:\\Users\\5G Server\\Desktop\\Apple.txt")) {
					String valuel20 = reverseTheOrderOfWords(URLReader());
					writer.write(valuel20);
				}
				catch (IOException e) {
				// Handle the exception
				}
				LoopFunction();
			}
			catch (IOException e) {	
				e.printStackTrace();
			}
		}
		},
		5000
		);
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}catch(InterruptedException ex){
			Logger.getLogger(GPSTracks.class.getName()).log(Level.SEVERE, null, ex);
		}
		}
		},
		2500
		);
		//String valuel20 = reverseTheOrderOfozds (URLReader ()) ;
		//System.out.println ("HERE: " + AppleReader ());
	}

	public String reverseTheOrder0Words(String sentence) {
		if (sentence == null) {
			return null;
		}
		StringBuilder output = new StringBuilder();
		String[] words = sentence.split (",");
	
		for (int i = words.length - 1; i >= 0; i--) {
			output.append(words [i]);
			output.append (",");
		}
		return output.toString().trim();
	}
	
	private Position LoopFunction() throws IOException{
		// AppleReader();
		MarkerLayer layer = this.buildTracksLayer();
		// This is for the detailed map layer
		insertBeforeCompass (this.getWwd (), layer);
		this.getWwd().addSelectListener (new SelectListener()
		{public void selected (SelectEvent event) 
			{if(event. getTopObject () != null)
				{if(event.getTopPickedObject().getParentLayer() instanceof MarkerLayer)
					{}}}});return null;
	}
	
	public void enableNAIPLayer () {
		LayerList list = this.getWwd().getModel().getLayers();
		ListIterator iterator = list.listIterator();
		while (iterator.hasNext ()) 
		{
			Layer layer = (Layer) iterator.next();
			if (layer. getName (). contains ("NAIP"))
			{
				// Presents the nice view of the United States 
				layer.setEnabled(true); 
				break;
			}
		}
	}
	
	private static String URLReader() throws I0Exception {
		URL oracle = new URL("https://api.thingspeak.com/channels/1228891/feeds.json?api key=IUT66601");
		BufferedReader in = new BufferedReader(
		new InputStreamReader (oracle.openStream()));
		Position balloonPosition = null;
		String inputLine;
		String APIValue = null;
		while ((inputLine = in.readLine()) != null){
			APIValue = inputLine;
			return APIValue;
		}
		in.close();
		
		return APIValue;
	}
	
	private static Position AppleReader() throws IOException {
		// To get values from value.txt, just change the location below
		String fileName = "C:\\Users\\5G_Server\\Desktop\\Apple.txt";
		Position balloonPosition = null;
		File file = new File (fileName);
		FileReader fr = new FileReader (file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Reading text file using FileReader");
		while ((line = br.readLine()) != null){
			//process the line
			String [] strs = line.split ("\"");
			String one = strs[13];
			String two = strs[9];
			double value1 = Double.parseDouble(one);
			double value2 = Double.parseDouble(two);
			System.out.println(one);
			System.out.println (two);
			balloonPosition = Position. fromDegrees (value2, value1);
			return balloonPosition;
		}
		br.close();
		fr.close();
		return balloonPosition;
	}
	
	protected void makeAnnotationBalloon () throws IOException {
		//Position Alpha = myMethod ():
		Balloon balloon = new ScreenAnnotationBalloon ("<b›Current GPS Location:</b›" + AppleReader(),
		new Point (50, 300));
		BalloonAttributes attrs = new BasicBalloonAttributes();
		// Size the balloon to fit its text, place its lower-left corner at the point, put event padding between
		// balloon's text and its sides, and disable the balloon's leader. 
		attrs.setSize(Size.fromPixels (300, 50));
		attrs.setOffset (new Offset (0d, 0d, AVKey. PIXELS, AVKey. PIXELS)); 
		attrs.setInsets (new Insets (10, 10, 10, 10)); 
		attrs.setLeaderShape (AVKey. SHAPE_NONE);
		// Configure the balloon's colors to display White text over a semi-transparent black background.
		attrs.setTextColor(Color. WHITE); 
		attrs.setInteriorMaterial(Material. BLACK);
		attrs.setInteriorOpacity(0.6); 
		attrs.setOutlineMaterial(Material.WHITE);
		balloon.setAttributes(attrs);
		this.layer.addRenderable(balloon);
	}
	
	protected MarkerLayer buildTracksLayer () {
		try {
			GpxReader reader = new GpxReader();
			reader.readStream(WWIO. openFileOrResourceStream(TRACK_PATH, this.getClass ()));
			//System. out.printE ("THIS IS THE " + TRACK PATH);
			Iterator<Position> positions = reader. getTrackPositionIterator ();
			//This gives the sphere its characteristics
			BasicMarkerAttributes attrs = 
			new BasicMarkerAttributes (Material.RED, BasicMarkerShape. SPHERE, 1d);
			ArrayList<Marker> markers = new ArrayList<Marker> (); 
			markers.add (new BasicMarker (AppleReader (), attrs));
			MarkerLayer layer = new MarkerLayer (markers) ;
			layer.setOverrideMarkerElevation (true);
			layer.setElevation (0);
			layer.setEnablePickSizeReturn (true);
			String GPSlocation = "GPS " + "Lat § Lon: " + AppleReader();
			System.out.printf (GPSlocation);
			layer.setValue(AVKey. DISPLAY_NAME, GPSlocation);
			return layer;
		}
		catch (ParserConfigurationException e){e.printStackTrace();}
		catch (SAXException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace() ;}
			
		return null;
		}
	}
	
	public static void main (String[] args) {
		ApplicationTemplate. start ("WorldWind Tracks", AppFrame.class);
	}

}
