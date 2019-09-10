package com.taxi.driver.base;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


public class VideoClass {

	private final Logger logger = LoggerFactory.getLogger(VideoClass.class);
	private static final String[] OPTIONS = { "--quiet", "--quiet-synchro", "--intf", "dummy" };

	private static final String MRL = "screen://";
	private static final String SOUT = ":sout=#transcode{vcodec=h264,vb=%d,scale=%f}:duplicate{dst=file{dst=%s}}";
	private static final String FPS = ":screen-fps=%d";
	private static final String CACHING = ":screen-caching=%d";

	private static final int fps = 20;
	private static final int caching = 500;
	private static final int bits = 1024;
	private static final float scale = 1.8f;

	private final MediaPlayerFactory mediaPlayerFactory;
	private final MediaPlayer mediaPlayer;

	public String videoName;
	public String mp4FileName;

	public VideoClass() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), System.getProperty("user.dir") + "/lib");
		System.setProperty("VLC_PLUGIN_PATH", System.getProperty("user.dir") + "/lib/plugins");
		mediaPlayerFactory = new MediaPlayerFactory(OPTIONS);
		mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
	}

	public void startRecording(String testName) {
		mp4FileName = getFile(testName);
		//TimeDynamo_BaseUrl.extentTest.log(Status.PASS, MarkupHelper.createLabel("start recording," + mp4FileName));
		//TimeDynamo_BaseUrl.extentTest.info("start recording,"+ mp4FileName);
		//logger.info("start recording,"+ mp4FileName);
		logger.info("start recording,"+ mp4FileName);
		mediaPlayer.playMedia(MRL, getMediaOptions(mp4FileName));
	}

	public void stopRecording() {
//		TimeDynamo_BaseUrl.extentTest.info("stop recording");
		logger.info("stop recording ");
		mediaPlayer.stop();
	}

	public void releaseRecordingResources() {
		mediaPlayer.release();
		mediaPlayerFactory.release();
	}

	private String getFile(String testName) {
		File dir = new File(System.getProperty("user.dir") + "/test-output", "mp4Result");
		dir.mkdirs();
		DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		videoName = df.format(new Date()) + ".mp4";
		System.out.println(videoName);
		return dir.getAbsolutePath() + "/" + testName + videoName;
	}

	private String[] getMediaOptions(String destination) {
		return new String[] { String.format(SOUT, bits, scale, destination), String.format(FPS, fps),
				String.format(CACHING, caching) };
	}
	////button[@class='glue-o-pagination__button'][@aria-label='Next']

}
