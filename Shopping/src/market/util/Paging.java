package market.util;

public class Paging {
	private int nowPage, //현재 페이지 
			    rowTotal, //총 게시물
			    blockList, //한 페이지에 표현할 게시물 수
			    blockPage, //한 블럭당 표현할 페이지 수
			    totalPage, //총 페이지 수
			    startPage, //시작 페이지
			    endPage, //마지막 페이지
			    begin, //시작 row
			    end; // 마지막 row
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	private boolean prePagePos; //이전 페이지 기능 가능 여부
	private boolean nxtPagePos; //다음 페이지 기능 가능 여부
	private StringBuffer sb; //JSP에서 표현할 페이징 HTML코드를 저장할 곳
	
	
	//1,1,10,5
	public Paging(int nowPage, int rowTotal, int blockList, int blockPage,String category) {
		super();
		this.nowPage = nowPage;
		this.rowTotal = rowTotal;
		this.blockList = blockList;
		this.blockPage = blockPage;
		
		//이전 페이지 , 다음 페이지 기능 초기화
		prePagePos = false;
		nxtPagePos = false;
		
		//입력된 전체 게시물의 수를 통해 전체 페이지 수를 구함
		totalPage = (Integer)(rowTotal/blockList);
		if(rowTotal%blockList!=0) {
			++totalPage;
		}
		
		//현재 페이지의 값이 전체 페이지의 값보다 크다면,
		//전체 페이지 갑을 현재 페이지 값으로 지정3
		if(nowPage > totalPage) {
			nowPage = totalPage;
		}
		if(nowPage<1) {
			nowPage = 1;
		}
		
		//현재 블럭의 시작페이지 값과 끝페이지 값을 구함
		if(nowPage<=3) {
			startPage=1;
		}else if(nowPage>=totalPage-2) {
			startPage=totalPage-4;
		}else {
			startPage=nowPage-2;
		}
		begin=((nowPage-1)*10)+1;
		end=begin+10;
		if(end>rowTotal) {
			end=rowTotal;
		}
		System.out.println("begin: "+begin);
		System.out.println("end: "+end);
		sb = new StringBuffer();
		for(int i=0;i<5;i++) {
			if(startPage+i>totalPage) {
				break;
			}
			String cur_page = Integer.toString(startPage+i);
			String a = "<a href='Controller?type=list&category="+category+"&page="+cur_page+"'>"+cur_page+"  </a>";
			sb.append(a);
		}
		
		
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPAge(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}
	public int getBlockList() {
		return blockList;
	}
	public void setBlockList(int blockList) {
		this.blockList = blockList;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isPrePagePos() {
		return prePagePos;
	}
	public void setPrePagePos(boolean prePagePos) {
		this.prePagePos = prePagePos;
	}
	public boolean isNxtPagePos() {
		return nxtPagePos;
	}
	public void setNxtPagePos(boolean nxtPagePos) {
		this.nxtPagePos = nxtPagePos;
	}
	public StringBuffer getSb() {
		return sb;
	}
	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	
			    
}