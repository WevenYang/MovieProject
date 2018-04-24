package com.example.administrator.traveldiary.util;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;

/**
 * Created by NewHT on 2016/12/18.
 */
public class GaodeMap implements LocationSource, AMapLocationListener {
    private OnLocationChangedListener mListener;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationClientOption;
    private static String mCityName, mCityDistrict;
    private AMap aMap;
    private MapView mapView;
    Context mContext;

    public GaodeMap(Context mContext) {
        this.mContext = mContext;
        mapView = new MapView(mContext);
        init();
    }

    public void init(){
        if (aMap == null){
            aMap = mapView.getMap();
            setUpMap();
        }
    }

    //设置一些amap的属性
    private void setUpMap() {
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);//设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null){
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0){
                mCityName = aMapLocation.getCity();
                mCityDistrict = aMapLocation.getDistrict();
                SharePreferenceUtils.setParam(mContext, "map", mCityName);
            }
        }else {
            String errText = "定位失败";
            MyToast.showMyToast(mContext, errText);
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mLocationClient == null){
            mLocationClient = new AMapLocationClient(mContext);
            mLocationClientOption = new AMapLocationClientOption();
            mLocationClientOption.setInterval(600000);
            mLocationClient.setLocationListener(this);
            mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mLocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mLocationClient != null){
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
        mLocationClient = null;
    }
}
