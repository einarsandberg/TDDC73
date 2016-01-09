package com.example.einarsandberg.projekt.InputFeedback;

import android.widget.RelativeLayout;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.einarsandberg.projekt.AccountParameter;
import com.example.einarsandberg.projekt.InputFeedback.Algorithm.AlgorithmFactory;
import com.example.einarsandberg.projekt.InputFeedback.Visualization.VisualizationFactory;

/**
 * Created by einarsandberg on 2015-12-11.
 */

/**
 * Class providing input feedback for the given parameters.
 * Contains an algorithmFactory to create the correct algorithm for that field,
 * and a visualizationFactory to create the correct input visualization.
 */
public class InputFeedback extends RelativeLayout
{
    Context context;
    private final static String TAG = "InputFeedback";

    List<AccountParameter> params;
    private final static String PASSWORD_VISUALIZATION_TYPE = "ProgressBar";
    private final static String TEXTFIELD_VISUALIZATION_TYPE = "TextFeedback";

    private AlgorithmFactory algorithmFactory;
    private VisualizationFactory visualizationFactory;

    public InputFeedback(Context theContext, List<AccountParameter> theParams)
    {
        super(theContext);
        context = theContext;
        params = new ArrayList<AccountParameter>();
        params = theParams;
        init();
    }

    private void init()
    {
        algorithmFactory = new AlgorithmFactory();
        visualizationFactory = new VisualizationFactory();
        initAlgorithms();
        initVisualizationTypes();
    }
    private void initAlgorithms()
    {
        for (int i = 0; i < params.size(); i++)
        {
            try
            {
                params.get(i).setAlgorithm(algorithmFactory.getAlgorithm(params.get(i).getName()));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private void initVisualizationTypes()
    {
        for (int i = 0; i < params.size(); i++)
        {
            if (params.get(i).hasAlgorithm())
            {
                if (params.get(i).getName().equals("Password"))
                {
                    params.get(i).setVisualizationMethod(visualizationFactory.getVisualizationMethod(context,
                            PASSWORD_VISUALIZATION_TYPE));
                }
                else
                {
                    params.get(i).setVisualizationMethod(visualizationFactory.getVisualizationMethod(context,
                            TEXTFIELD_VISUALIZATION_TYPE));
                }
            }
        }
    }


}
