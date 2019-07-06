package com.bawei.gaochenkai.di.iconatre;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/3 09:40:42
 * @Description: MVP的契约类
 */
public interface IConater {
    /*
    V层
     */
    public interface IView{
        public void showData();
    }

    /*
    P层
     */
    public interface IPresentre<IView>{
        //获取V层对象
        public void getV(IConater.IView iView);
        //解绑
        public void attchData();
        //与M层绑定
        public void PM();
    }

    /*
    M层
     */
    public interface IModel{
        public void CallBack();
        public void MV();
    }

}
