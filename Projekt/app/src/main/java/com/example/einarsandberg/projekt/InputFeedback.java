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
    RelativeLayout.LayoutParams barParams;
    PasswordStrengthBar pwBar;
    List<TextView> textViewList;
    List<EditText> editTextList;
    List<LayoutParams> layoutTextViewList;
    List<LayoutParams> layoutEditTextList;

    private int lastTextViewTopMargin;
    private int lastEditTextTopMargin;

    List<AccountParameter> params;
    private final static int MARGIN_TOP_BETWEEN_TEXTVIEW = 250;
    private final static int MARGIN_TOP_BETWEEN_EDITTEXT = 250;
    private final static int LEFT_MARGIN_EDITTEXT = 200;
    private final static String PASSWORD_VISUALIZATION_TYPE = "ProgressBar";
    private final static String TEXTFIELD_VISUALIZATION_TYPE = "FieldColorFeedback";
    Button button;

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
        pwBar = new PasswordStrengthBar(context, null, android.R.attr.progressBarStyleHorizontal);
        pwBar.setBar("Too short", 20);
        textViewList = new ArrayList<TextView>();
        editTextList = new ArrayList<EditText>();
        layoutTextViewList = new ArrayList<LayoutParams>();
        layoutEditTextList = new ArrayList<LayoutParams>();

        for (int i = 0; i < params.size(); i++)
        {
            textViewList.add(new TextView(context));
            textViewList.get(i).setText(params.get(i).getName());
            Log.d(TAG, params.get(i).toString());
            editTextList.add(new EditText(context));
            if (params.get(i).getName().equals("Password"))
            {
                editTextList.get(i).setTransformationMethod(new PasswordTransformationMethod());
            }
        }
        button = new Button(context);
        button.setText("Register");

        addTextListeners();

      /*

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validAddress && validEmail && !passwordStrengthMeter.getValidPassword().equals("")) {
                    Account account = new Account(editEmail.getText().toString(), editAddress.getText().toString(),
                            passwordStrengthMeter.getValidPassword());
                    account.print();
                }
            }
        });*/

    }
    private void addTextListeners()
    {
        for (int i = 0; i < params.size(); i++)
        {
            // wont work inside onTextChanged if not final
            final int k = i;
            // if there is an algorithm for this field
            if (params.get(k).hasAlgorithm())
            {
                params.get(k).setAlgorithm(algorithmFactory.getAlgorithm(params.get(k).getName()));
                if (params.get(k).getName().equals("Password"))
                {
                    params.get(k).setVisualizationMethod(visualizationFactory.getVisualizationMethod(context,
                            PASSWORD_VISUALIZATION_TYPE));
                }
                else
                {
                    params.get(k).setVisualizationMethod(visualizationFactory.getVisualizationMethod(context,
                            TEXTFIELD_VISUALIZATION_TYPE));
                }
                editTextList.get(k).addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count)
                    {
                        if (params.get(k).getFieldAlgorithm().checkField(s.toString()))
                        {
                            Log.d(TAG, "HEJ PÅ LILLA DIG");
                            // editTextList.get(k).setBackgroundColor(Color.parseColor("#99cc00"));
                            editTextList.get(k).setBackgroundColor(
                                    params.get(k).getVisualizationMethod().getGoodFeedback());
                        }
                        else
                        {
                            editTextList.get(k).setBackgroundColor(
                                    params.get(k).getVisualizationMethod().getBadFeedback());

                        }

                        if (params.get(k).getName().equals("Password"))
                        {
                            params.get(k).getVisualizationMethod().setBar(params.get(k).getFieldAlgorithm().getStrengthLevel(s.toString()),
                                    params.get(k).getFieldAlgorithm().getProgress(
                                            params.get(k).getFieldAlgorithm().getStrengthLevel(s.toString())));
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        }
    }
    private void initLayout()
    {
        relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        this.setLayoutParams(relativeParams);

        barParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        barParams.topMargin = 700;

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
            editTextList.get(i).setLayoutParams(layoutEditTextList.get(i));
            lastEditTextTopMargin = lastEditTextTopMargin + MARGIN_TOP_BETWEEN_EDITTEXT;
            barParams.topMargin = lastEditTextTopMargin;
            addView(textViewList.get(i));
            addView(editTextList.get(i));

           try
            {
                addView(params.get(i).getVisualizationMethod().getView(), barParams);
            }
            catch(Exception e)
            {
                e.printStackTrace();
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
