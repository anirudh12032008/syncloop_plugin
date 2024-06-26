package packages.Spotify_Plugin.api;

import com.eka.middleware.service.DataPipeline;
import com.eka.middleware.service.ServiceUtils;
import com.eka.middleware.template.SnippetException;
import com.eka.middleware.flow.FlowResolver;
import java.io.File;
import java.io.FileInputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import com.eka.middleware.service.PropertyManager;
import java.util.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;
import io.undertow.util.HttpString;
import com.eka.middleware.heap.CacheManager;//-----reset fix

public final class album_info_api {

	private static Long timeout=0l;//-----reset fix
	private static Integer resetServiceInMS=5000;//-----reset fix
	static final String syncBlock=new String("sync");
	private static JsonObject mainflowJsonObject=null;
	public static final void main(DataPipeline dataPipeline) throws SnippetException{
		String fqn="packages.Spotify_Plugin.api.album_info_api";
		Map<String, Object> passThroughData=new HashMap<>();
		Long startTime=System.currentTimeMillis();
		Long nanoSec=System.nanoTime();
		passThroughData.put("nanoSec", nanoSec);
	    passThroughData.put("startTime", startTime);
		passThroughData.put("flowRef", "packages/Spotify_Plugin/api/album_info_api.api");
		passThroughData.put("timeout", timeout);
		passThroughData.put("resetServiceInMS", resetServiceInMS);
		try{
		  ServiceUtils.beforeServiceExecution(dataPipeline,fqn,passThroughData);
		  mainflowJsonObject = (JsonObject) passThroughData.get("mainflowJsonObject");
		}catch(Throwable e) {
			dataPipeline.clear();
			dataPipeline.put("error", e.getMessage());
			//dataPipeline.setResponseStatus(500);
			dataPipeline.put("status", "Service error");
			throw new SnippetException(dataPipeline,"Failed to execute album_info_api", new Exception(e));
		}finally{
			try{
				ServiceUtils.afterServiceExecution(dataPipeline,fqn,passThroughData);
			}catch(Exception e){}
		}
	}
}
