package �γ����;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class TestLog.
 *
 * @date 2020-7-3
 * @author ���׭Z
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
		log4j.debug("������ʲô����");
		log4j.info("ҵ����Ϣ");
		log4j.warn("�澯��Ϣ");
		try {
			
		}catch(Exception e) {
			log4j.error(e.getMessage());
		}

	}

}
