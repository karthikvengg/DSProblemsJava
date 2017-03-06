package snippet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JAXBDemoBean {

	private String uname;
	private String pwd;
	
	public JAXBDemoBean(){}
	
	public JAXBDemoBean(String uname, String pwd) {
		this.uname = uname;
		this.pwd = pwd;
	}

	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
