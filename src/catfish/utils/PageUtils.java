/**
 * 
 */
package catfish.utils;
import train.TrainConstants;
import train.TrainConstants.PageType;
import train.utils.PageClassifier;
import catfish.config.DIConfig;
import catfish.model.FetchedDocument;
import catfish.transport.exception.TransportException;
import catfish.transport.http.HttpTransport;

/**  
 * Filename:    PageUtils.java  
 * Description:   
 * @author:     chenran  
 * @version:    1.0  
 * Create at:   2012-2-13 下午4:07:26  
 */

public class PageUtils {

	public static PageType getPageType(FetchedDocument fetchedDocument){
		
		PageClassifier pageClassifier = new PageClassifier(TrainConstants.MODEL_LOCATION);
		return pageClassifier.doClassify(fetchedDocument);
	}
	
	public static void main(String[] args) {
		HttpTransport httpTransport;
		httpTransport = DIConfig.getInjector().getInstance(HttpTransport.class);
		try {
			PageType pageType = PageUtils.getPageType(httpTransport.fetch("http://tech.163.com/"));
			System.out.println(pageType);
		} catch (TransportException e) {
			e.printStackTrace();
		}

	}
	
	
}
