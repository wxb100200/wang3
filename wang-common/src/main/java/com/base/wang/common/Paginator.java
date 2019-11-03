package com.base.wang.common;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

public class Paginator implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private int firstPage;
    private int prePage;
    private int nextPage;
    private int lastPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int[] navigatepageNums;

    public Paginator(){
        this.pageNum=1;
        this.pageSize=10;

    }

    public Paginator(Page page) {
        this(page, 10);
    }

    public Paginator(Page page, int navigatePages) {
        this.isFirstPage = false;
        this.isLastPage = false;
        this.hasPreviousPage = false;
        this.hasNextPage = false;
        if(page instanceof Page) {
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            if(this.pageSize == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else  if(this.pageNum<this.pages){
                this.startRow = page.getStartRow() + 1;
                this.endRow = this.startRow - 1 + this.pageSize;
            }else{
                this.startRow = page.getStartRow() + 1;
                this.endRow=(int)page.getTotal();
            }

            this.navigatePages = navigatePages;
            this.calcNavigatepageNums();
            this.calcPage();
            this.judgePageBoudary();
        }

    }

    private void calcNavigatepageNums() {
        int startNum;
        if(this.pages <= this.navigatePages) {
            this.navigatepageNums = new int[this.pages];

            for(startNum = 0; startNum < this.pages; ++startNum) {
                this.navigatepageNums[startNum] = startNum + 1;
            }
        } else {
            this.navigatepageNums = new int[this.navigatePages];
            startNum = this.pageNum - this.navigatePages / 2;
            int endNum = this.pageNum + this.navigatePages / 2;
            int i;
            if(startNum < 1) {
                startNum = 1;

                for(i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = startNum++;
                }
            } else if(endNum > this.pages) {
                endNum = this.pages;

                for(i = this.navigatePages - 1; i >= 0; --i) {
                    this.navigatepageNums[i] = endNum--;
                }
            } else {
                for(i = 0; i < this.navigatePages; ++i) {
                    this.navigatepageNums[i] = startNum++;
                }
            }
        }

    }

    private void calcPage() {
        if(this.navigatepageNums != null && this.navigatepageNums.length > 0) {
            this.firstPage = this.navigatepageNums[0];
            this.lastPage = this.navigatepageNums[this.navigatepageNums.length - 1];
            if(this.pageNum > 1) {
                this.prePage = this.pageNum - 1;
            }

            if(this.pageNum < this.pages) {
                this.nextPage = this.pageNum + 1;
            }
        }

    }

    private void judgePageBoudary() {
        this.isFirstPage = this.pageNum == 1;
        this.isLastPage = this.pageNum == this.pages;
        this.hasPreviousPage = this.pageNum > 1;
        this.hasNextPage = this.pageNum < this.pages;
    }

    //自义定列表的分页
    public void init(Long count,Integer rowNum,Integer navigatePages){
        if (navigatePages == null)
            this.navigatePages = 10;

        this.total = count;

        this.pages = (int) ((count/pageSize)+1);
        this.navigatepageNums = new int[pages];
        for (int i = 0;i< pages;i++)
        {
            navigatepageNums[i]=i+1;
        }

        if (rowNum == 0){
            this.startRow = 0;
            this.endRow = 0;
        }else {
            this.startRow = 1;
            this.endRow = this.startRow + rowNum -1;
        }

        judgePageBoudary();
        calcPage();

    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getStartRow() {
        return this.startRow;
    }

    public int getEndRow() {
        return this.endRow;
    }

    public long getTotal() {
        return this.total;
    }

    public int getPages() {
        return this.pages;
    }

    public int getFirstPage() {
        return this.firstPage;
    }

    public int getPrePage() {
        return this.prePage;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public int getLastPage() {
        return this.lastPage;
    }

    public boolean isIsFirstPage() {
        return this.isFirstPage;
    }

    public boolean isIsLastPage() {
        return this.isLastPage;
    }

    public boolean isHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public int getNavigatePages() {
        return this.navigatePages;
    }

    public int[] getNavigatepageNums() {
        return this.navigatepageNums;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    /**
     * 自定义的分页用于分页导航栏
     */
    public static Paginator generatePagination(List list, int pageSize, int pageNum){
        Paginator p=new Paginator();
        if(list==null || list.isEmpty()){
            p.setPageNum(0);
            p.setPageSize(0);
            p.setStartRow(0);
            p.setEndRow(0);
            return p;
        }
        int total=list.size();//总记录条数
        pageSize=pageSizeJudge(pageSize,total);
        int pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
        pageNum=pageNumJudge(pageNum,pages);

        p.setPageNum(pageNum);
        p.setPageSize(pageSize);
        p.setStartRow(pageSize*(pageNum-1)+1);
        int endRow=pageSize*pageNum>total ? total:pageSize*pageNum;
        p.setEndRow(endRow);
        p.setTotal(total);
        p.setPages(pages);
        p.setFirstPage(1);

        int prePage=pageNum-1<1 ? 1:pageNum-1;//前一页
        p.setPrePage(prePage);
        int nextPage=pageNum+1>pages ? pages:pageNum+1;
        p.setNextPage(nextPage);
        p.setLastPage(pages);
        if(pageNum==1){
            p.setFirstPage(true);
        }else {
            p.setFirstPage(false);
        }
        if(pageNum==pages){
            p.setLastPage(true);
        }else {
            p.setLastPage(false);
        }
        p.setNavigatepageNums(generateNums(pages,pageNum));
        return p;
    }
    private static int[] generateNums(int pages,int pageNum){ //todo
        int a=1;
        int b=10;
        if(pages>10 && pageNum>5){
            b=pageNum+5>pages ? pages:pageNum+5;
            a=b-9;
        }
        int[] nums=new int[10];
        int i=0;
        for(int num=a;num<=b;num++){
            nums[i++]=num;
        }
        return nums;
    }

    private static  int pageNumJudge(int pageNum,int pages ){
        if(pageNum>pages){
            pageNum=pages;
        }
        if(pageNum<1){
            pageNum=1;
        }
        return pageNum;
    }
    private static int pageSizeJudge(int pageSize,int total){
        if(pageSize<1){
            pageSize=1;
        }
        if(pageSize>total){
            pageSize=total;
        }
        return pageSize;
    }
}
