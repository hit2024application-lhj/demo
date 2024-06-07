package org.example.myapp.utils;

import org.example.myapp.bean.PageResult;

import java.util.List;

public class MyPageHelper<T> {

    //接受一个列表
    List<T> data;

    int totalSize;

    public MyPageHelper(List<T> data) {
        this.data=data;
        totalSize = data.size();
    }

    /**
     *
     * @param PageNumber 页号
     * @param PageSize 每页的大小
     * @return
     */
    public List<T> startPage(int PageNumber,int PageSize){
        int maxPage=totalSize/PageSize+1;
        PageNumber=Math.min(PageNumber,maxPage);
        int startIndex=(PageNumber-1)*PageSize;
        int endIndex=Math.min(startIndex+PageSize,totalSize);
        return data.subList(startIndex,endIndex);
    }


    /**
     * 获取总页数，可以在第一次刷新后得到
     * @param PageNumber
     * @param PageSize
     * @return
     */
    public Integer getTotalPage(int PageNumber,int PageSize){
        int maxPage=totalSize/PageSize+1;
        PageNumber=Math.min(PageNumber,maxPage);
        return PageNumber;
    }

    /**
     * 直接获取整页完整数据比较好
     * @param PageNumber
     * @param PageSize
     * @return
     */
    public PageResult getPageResult(int PageNumber,int PageSize){
        int maxPage=totalSize/PageSize+1;
        PageNumber=Math.min(PageNumber,maxPage);
        int startIndex=(PageNumber-1)*PageSize;
        int endIndex=Math.min(startIndex+PageSize,totalSize);
        PageResult pageResult=new PageResult();
        pageResult.setRows(data.subList(startIndex,endIndex));
        pageResult.setTotal(maxPage);

        return pageResult;
    }
}
