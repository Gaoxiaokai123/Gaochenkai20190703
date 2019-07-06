package com.bawei.gaochenkai20190705.di.contract;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/5 19:26:53
 * @Description:
 */
public interface IContract {
    /*
    V层接口
     */
    public interface IView{
        public void showData();
        //网络请求完毕后的回显数据方法
        public void sshowResponseData();
    }

    /*
    P层
     */
    public interface IPresenter<IView>{
        //和V层关联
        public void attachView(IContract.IView iView);
        //解绑
        public void detachView();
        //获取V层内容.和M层交互
        public void containInfo(String userName, String passWord);
    }

    /*
    M层接口
     */
    public interface IModel{
        //数据请求
        public void requestData();
        //回传数据的接口
        public interface CallBack{
            public void getResult();
            //M层网络回显结果
            public void getData();
        }
    }

}
