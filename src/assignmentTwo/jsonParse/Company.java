package assignmentTwo.jsonParse;

import java.util.ArrayList;
import java.util.List;


public class Company {
	
	private String company;
	private String industry;
	private String subIndustry;
	private String sector;
	private String description;
	private String phone;
	private String fax;
	private String weburl;
	List<KeyPeople> keyPeople = new ArrayList<>();
	
	public Company() {
	}
	
	public Company(String company, String industry, String subIndustry, String sector, String description, String phone,
			String fax, String weburl, List<KeyPeople> keyPeople) {
		this.company = company;
		this.industry = industry;
		this.subIndustry = subIndustry;
		this.sector = sector;
		this.description = description;
		this.phone = phone;
		this.fax = fax;
		this.weburl = weburl;
		this.keyPeople = keyPeople;
	}
	
	public String getCompany() {
		return company;
	}

	public String getDescription() {
		return description;
	}
	
	public String getFax() {			
		return fax.replace("-","");
	}

	public String getWeburl() {
		return weburl;
	}

	@Override
	public String toString() {
		return "company=" + company + ", industry=" + industry + ", subIndustry=" + subIndustry + ", sector="
				+ sector + ", description=" + description + ", phone=" + phone + ", fax=" + fax + ", weburl=" + weburl
				+ ", keyPeople=" + keyPeople + "]";
	}
	
	

}
