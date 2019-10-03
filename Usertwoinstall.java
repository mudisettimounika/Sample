package com.taxi.user.pages;

import java.net.MalformedURLException;

import Twousers.Mainclass;
import io.appium.java_client.android.AndroidDriver;

public class Usertwoinstall implements Runnable {
	AndroidDriver driver;

	public void run() {
		Mainclass m = new Mainclass("FINZQSEE6DTOGUIF", "4723", "Gionee a1", "user2","","");
		try {

			driver = m.cap();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (Mainclass.isFirstBrodcasted) {
				Userone s = new Userone(driver);
				s.fromdropdown();
				s.fromlocation();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				s.todropdown();
				s.tolocation();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				s.broadcastbtn();

				if (Mainclass.isSeconUserDone = true) {
					s.paynowbtn();
					System.exit(0);
				}

				// status
				// Mainclass.isSeconUserDone=true;
			}
		}

	}

}