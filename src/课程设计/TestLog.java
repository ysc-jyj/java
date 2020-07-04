package 课程设计;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class TestLog.
 *
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class TestLog {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Logger log4j=Logger.getLogger(TestLog.class);
		System.out.println("xxx");
		log4j.debug("进入了什么方法");
		log4j.info("业务信息");
		log4j.warn("告警信息");
		try {
			
		}catch(Exception e) {
			log4j.error(e.getMessage());
		}

	}

}
