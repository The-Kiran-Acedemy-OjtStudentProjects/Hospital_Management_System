package com.hospitalmanagement.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {
	
	//MD5 Hashing Algorithm
	public static String doHashing (String password)
	{
		  StringBuilder sb = null;
		  try {
		   MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		   
		   messageDigest.update(password.getBytes());
		   
		   byte[] resultByteArray = messageDigest.digest();
		   
		   sb = new StringBuilder();
		   
		   for (byte b : resultByteArray) {
		    sb.append(String.format("%02x", b));
		   }
		   
		   
		   
		  } catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();
		  }
		 
		  return sb.toString();
    }

}
