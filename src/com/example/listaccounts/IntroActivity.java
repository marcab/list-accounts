package com.example.listaccounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class IntroActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Mark spans
        SpannableString spannedPermissions = new SpannableString(
                "<uses-permission android:name=\"android.permission.GET_ACCOUNTS\"/>");
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.CYAN), 0, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.GREEN), 17,
                24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.MAGENTA), 24,
                25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.GREEN), 25,
                29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.RED), 30, 63,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedPermissions.setSpan(new ForegroundColorSpan(Color.CYAN), 63, 65,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView)findViewById(R.id.permissions)).setText(spannedPermissions);

        // Get raw spanned text
        Resources res = getResources();
        BufferedReader input = new BufferedReader(new InputStreamReader(
                res.openRawResource(R.raw.get_accounts)));
        StringBuffer sb = new StringBuffer();
        try {
            String line;
            while ((line = input.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Spanned spannedCode = Html.fromHtml(sb.toString());
        ((TextView)findViewById(R.id.code_sample)).setText(spannedCode);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ListAccountsActivity.class);
        startActivity(intent);
        finish();
    }

}
