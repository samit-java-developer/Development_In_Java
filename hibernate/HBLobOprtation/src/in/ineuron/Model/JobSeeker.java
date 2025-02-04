package in.ineuron.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class JobSeeker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jsId;

	@Column(length = 10)
	private String jsName;

	private Boolean isActive;

	@Lob
	private byte[] jsPhoto;

	@Lob
	private char[] jsResume;

	public Integer getJsId() {
		return jsId;
	}

	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}

	public String getJsName() {
		return jsName;
	}

	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public byte[] getJsPhoto() {
		return jsPhoto;
	}

	public void setJsPhoto(byte[] jsPhoto) {
		this.jsPhoto = jsPhoto;
	}

	public char[] getJsResume() {
		return jsResume;
	}

	public void setJsResume(char[] jsResume) {
		this.jsResume = jsResume;
	}

}
