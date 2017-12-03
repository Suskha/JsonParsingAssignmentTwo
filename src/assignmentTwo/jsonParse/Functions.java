package assignmentTwo.jsonParse;

import java.io.BufferedWriter;
import java.io.IOException;

public class Functions {

	private int count ;
	private Company[] ef = new Company[count];
	
	public void setEf(Company[] ef) {
		this.ef = ef;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void toWriteFile(BufferedWriter bd, Company d) throws IOException {
		String companyDescription= null;
		if (d.getDescription().isEmpty()) {
			companyDescription = "no description available";
		} else{
			companyDescription = d.getDescription();
		}
		String completeUpdate = d.getCompany() + " : " + companyDescription;
		bd.write(completeUpdate);
		bd.newLine();
	}

	public void showCompanyKeyValue() {
		for (int i = 0; i < count; i++) {
			if ((ef[i].keyPeople.size()) > 0) {
				System.out.println(ef[i]);
			}
		}
	}

	public void showFax() {
		for (int i = 0; i < count; i++) {
			if ((ef[i].getFax().isEmpty()) != true ) {
				System.out.printf("Fax number : %11s", ef[i].getFax());
				System.out.println(" Company : " + ef[i].getCompany());
			}
		}
	}

	public void showWebUrl() {
		String URL ="";
		for (int i = 0; i < count; i++) {
			if ((URL=ef[i].getWeburl()) != null) {
				String domain = URL.replaceAll("^[w]*[0-9]*\\.", "");
				System.out.println("WebUrl : " + domain.replaceAll("[\\/].*", ""));
			}
		}
	}
	
}
