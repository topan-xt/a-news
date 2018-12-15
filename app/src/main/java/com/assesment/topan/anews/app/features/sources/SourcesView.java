package com.assesment.topan.anews.app.features.sources;

import com.assesment.topan.anews.app.base.BaseView;
import com.assesment.topan.anews.model.SourceNewsModel;

import java.util.List;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 24, 2018.                    *
 *************************************************/
public interface SourcesView extends BaseView {
    void setAdapter(List<SourceNewsModel.Sources> sourcesList);
}
