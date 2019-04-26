package member;

public class BbsMember {
	private int id;
	private String name;
	private String title;
	private String date;
	private String content;
	
	
	public BbsMember(int id, String name, String title, String date, String content) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	public BbsMember() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BbsMember [id=" + id + ", name=" + name + ", title=" + title + ", date=" + date + ", content=" + content
				+ "]";
	}

}
