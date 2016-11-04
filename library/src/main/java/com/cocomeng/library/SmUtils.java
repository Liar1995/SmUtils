package com.cocomeng.library;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sunmeng on 2016/11/4.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

public class SmUtils {
    private final static String DEFAULT_DBNAME = "SmUtils";

    public static void ToastUtils(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
