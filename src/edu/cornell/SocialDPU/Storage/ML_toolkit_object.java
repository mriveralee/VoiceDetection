package edu.cornell.SocialDPU.Storage;

import java.io.Serializable;

/**
 * This class contains different object suitable for different data(sensor) types
 * Different sensor has differnt syncing requirement with data and corersponding inferences
 */
public class ML_toolkit_object implements Serializable{


	private static final long serialVersionUID = 1L;
	//int timestamp;
	public int datatype;
	public byte[] data;
	public long timestamp;
	public String inferred_results_or_label_info;
	public boolean isStart;
	public int sync_id; 

	public ML_toolkit_object() {
		this(-1, -1, null);
	}
	
	public ML_toolkit_object(long timestamp, int datatype, byte[] data)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features, 5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end 
		this.datatype = datatype;  
		this.data = data;
		this.timestamp = timestamp;
		this.inferred_results_or_label_info = null;
		this.isStart = false;//it doesn't matter because 
	}
	
	public ML_toolkit_object(long timestamp, int datatype, boolean isStart2, String str)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features, 5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end 
		this.datatype = datatype;  
		//this.data = data;
		this.inferred_results_or_label_info = str;
		this.data = null;
		this.timestamp = timestamp;
		this.isStart = isStart2;
	}

	public ML_toolkit_object(long timestamp, int datatype, byte[] data,int sync_id)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		//13-sleep
		this.datatype = datatype;  
		this.data = data;
		this.timestamp = timestamp;
		this.inferred_results_or_label_info = null;
		this.isStart = false;//it doesn't matter because 
		this.sync_id = sync_id;//sync with inference data
	}
	
	//for labels
	public ML_toolkit_object(long timestamp, int datatype, boolean isStart2, String str,int sync_id)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		//13-sleep
		this.datatype = datatype;  
		//this.data = data;
		this.inferred_results_or_label_info = str;
		this.data = null;
		this.timestamp = timestamp;
		this.isStart = isStart2;
		this.sync_id = sync_id;//sync with inference data
	}




	
	public ML_toolkit_object setValues(long timestamp, int datatype, byte[] data)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		//13-sleep
		this.datatype = datatype;  
		this.data = data;
		this.timestamp = timestamp;
		this.inferred_results_or_label_info = null;
		this.isStart = false;//it doesn't matter because 
		this.sync_id = -1;
		return this;
	}
	
	//for labels
	public ML_toolkit_object setValues(long timestamp, int datatype, boolean isStart2, String str)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		//13-sleep
		this.datatype = datatype;  
		//this.data = data;
		this.inferred_results_or_label_info = str;
		this.data = null;
		this.timestamp = timestamp;
		this.isStart = isStart2;
		this.sync_id = -1;
		return this;
	}

	
	public ML_toolkit_object setValues(long timestamp, int datatype, byte[] data,int sync_id)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		this.datatype = datatype;  
		this.data = data;
		this.timestamp = timestamp;
		this.inferred_results_or_label_info = null;
		this.isStart = false;//it doesn't matter because 
		this.sync_id = sync_id;//sync with inference data
		return this;
	}
	
	//for labels
	public ML_toolkit_object setValues(long timestamp, int datatype, boolean isStart2, String str,int sync_id)
	{
		//0 = audio, 1=accelerometer, 2=location, 3 = audio features, 4 = accel features,
		//5 = audio inference, 6 = accel inference, 7 = label_start , 8 = label_end, 9=wifi_scan_data 
		//10=bluetooth_data 
		//11-NTPtimestamps
		//12-Momentary Samples
		//13-sleep
		this.datatype = datatype;  
		//this.data = data;
		this.inferred_results_or_label_info = str;
		this.data = null;
		this.timestamp = timestamp;
		this.isStart = isStart2;
		this.sync_id = sync_id;//sync with inference data
		return this;
	}

	
	

	/** Converts an object to an array of bytes . Uses the Logging 
	utilities in j2sdk1.4 for
	 * reporting exceptions.
	 * @param object the object to convert.
	 * @return the associated byte array.
	 */
	public static byte[] toBytes(Object object){
		java.io.ByteArrayOutputStream baos = new 
		java.io.ByteArrayOutputStream();
		try{
			java.io.ObjectOutputStream oos = new 
			java.io.ObjectOutputStream(baos);
			oos.writeObject(object);
		}catch(java.io.IOException ioe){
			//java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE, 
				//	ioe.getMessage());
		}
		return baos.toByteArray();
	}

	//byte array to object
	/** Converts an array of bytes back to its constituent object. The 
	input array is assumed to
	 * have been created from the original object. Uses the Logging 
	utilities in j2sdk1.4 for
	 * reporting exceptions.
	 * @param bytes the byte array to convert.
	 * @return the associated object.
	 */
	
	//do a casting to get the original object
	public static Object toObject(byte[] bytes){
		Object object = null;
		try{
			object = new java.io.ObjectInputStream(new 
					java.io.ByteArrayInputStream(bytes)).readObject();
		}catch(java.io.IOException ioe){
			//java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE, 
				//	ioe.getMessage());
		}catch(java.lang.ClassNotFoundException cnfe){
			//java.util.logging.Logger.global.log(java.util.logging.Level.SEVERE, 
				//	cnfe.getMessage());
		}
		return object;
	}
	
}