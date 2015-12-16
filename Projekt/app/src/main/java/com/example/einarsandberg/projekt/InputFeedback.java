package com.example.einarsandberg.projekt;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;

import android.text.style.BackgroundColorSpan;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import android.text.method.PasswordTransformationMethod;
/**
 * Created by einarsandberg on 2015-12-11.
 */
public class InputFeedback extends RelativeLayout
{
    Context context;
    private final static String TAG = "InputFeedback";
    RelativeLayout.LayoutParams relativeParams;
    RelativeLayout.LayoutParams buttonParams;

    List<TextView> textViewList;
    List<LayoutParams> layoutTextViewList;
    List<LayoutParams> layoutEditTextList;
    List<LayoutParams> layoutFeedbackList;
    private int lastTextViewTopMargin;
    private int lastEditTextTopMargin;

    List<AccountParameter> params;
    private final static int MARGIN_TOP_BETWEEN_TEXTVIEW = 250;
    private final static int MARGIN_TOP_BETWEEN_EDITTEXT = 250;
    private final static int LEFT_MARGIN_EDITTEXT = 200;
    private final static String PASSWORD_VISUALIZATION_TYPE = "ProgressBar";
    private final static String TEXTFIELD_VISUALIZATION_TYPE = "TextFeedback";
    Button button;

    List<InteractiveField> interactiveFields;

    private AlgorithmFactory algorithmFactory;
    private VisualizationFactory visualizationFactory;

    public InputFeedback(Context theContext, List<AccountParameter> theParams)
    {
        super(theContext);
        context = theContext;
        lastTextViewTopMargin = 50;
        lastEditTextTopMargin = 0;
        params = new ArrayList<AccountParameter>();
        params = theParams;
        init();
        initLayout();
    }

    private void init()
    {
        algorithmFactory = new AlgorithmFactory();
        visualizationFactory = new VisualizationFactory();

        textViewList = new ArrayList<TextView>();

        layoutTextViewList = new ArrayList<LayoutParams>();
        layoutEditTextList = new ArrayList<LayoutParams>();
        interactiveFields = new ArrayList<InteractiveField>();
        initVisualizationTypes();

        for (int i = 0; i < params.size(); i++)
        {
            textViewList.add(new TextView(context));
            textViewList.get(i).setText(params.get(i).getName());

            interactiveFields.add(new InteractiveField(context, params.get(i)));

            if (params.get(i).getName().equals("Password"))
            {
                interactiveFields.get(i).setTransformationMethod(new PasswordTransformationMethod());
            }
        }
        button = new Button(context);
        button.setText("Register");
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
    private void initLayout()
    {
        relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        this.setLayoutParams(relativeParams);


        for (int i = 0; i < textViewList.size(); i++)
        {
            layoutTextViewList.add(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            layoutTextViewList.get(i).addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
            layoutTextViewList.get(i).topMargin = lastTextViewTopMargin;
            lastTextViewTopMargin = lastTextViewTopMargin + MARGIN_TOP_BETWEEN_TEXTVIEW;

            textViewList.get(i).setLayoutParams(layoutTextViewList.get(i));

            layoutEditTextList.add(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            layoutEditTextList.get(i).leftMargin = LEFT_MARGIN_EDITTEXT;
            layoutEditTextList.get(i).topMargin = lastEditTextTopMargin;
            interactiveFields.get(i).setLayoutParams(layoutEditTextList.get(i));

            lastEditTextTopMargin = lastEditTextTopMargin + MARGIN_TOP_BETWEEN_EDITTEXT;
            if (interactiveFields.get(i).getAccountParameter().hasAlgorithm())
            {
                interactiveFields.get(i).getAccountParameter().getVisualizationMethod().
                        setPosition(lastEditTextTopMargin + 7);
            }
            addView(textViewList.get(i));
            addView(interactiveFields.get(i));

            if (interactiveFields.get(i).getAccountParameter().hasAlgorithm())
            {
                addView(interactiveFields.get(i).getAccountParameter().getVisualizationMethod().getView());
            }

        }

        buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.topMargin = 900;
        buttonParams.rightMargin = 500;
        buttonParams.leftMargin = 500;

        //addView(pwBar);
        addView(button, buttonParams);
    }
}
