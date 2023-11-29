package model;

public class Material {
	private int materialId;
	private String materialName;
	private int page_start;
	private int page_end;
	private int section_start;
	private int section_end;
	
	public Material(int materialId, String materialName, int page_start, int page_end, int section_start, int section_end) {
		this.materialId = materialId;
		this.materialName = materialName;
		this.page_start = page_start;
		this.page_end = page_end;
		this.section_start = section_start;
		this.section_end = section_end;
	}
	
	//数が多いのでチャットGPTで記述
	public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setPage_start(int page_start) {
        this.page_start = page_start;
    }

    public int getPage_start() {
        return page_start;
    }

    public void setPage_end(int page_end) {
        this.page_end = page_end;
    }

    public int getPage_end() {
        return page_end;
    }

    public void setSection_start(int section_start) {
        this.section_start = section_start;
    }

    public int getSection_start() {
        return section_start;
    }

    public void setSection_end(int section_end) {
        this.section_end = section_end;
    }

    public int getSection_end() {
        return section_end;
    }
}
