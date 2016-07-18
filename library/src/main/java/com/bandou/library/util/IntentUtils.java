/*
 * Copyright (C) 2016 venshine.cn@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bandou.library.util;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;

/**
 * Intent操作
 *
 * @author venshine
 */
public class IntentUtils {
    /**
     * 判断intent和它的bundle是否为空
     *
     * @param intent the intent
     * @return boolean
     */
    public static boolean isBundleEmpty(Intent intent) {
        return (intent == null) && (intent.getExtras() == null);
    }

    /**
     * Search a word in a browser
     *
     * @param context the context
     * @param string  the string
     * @return the boolean
     */
    public static boolean search(Context context, String string) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, string);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open url in a browser
     *
     * @param context the context
     * @param url     the url
     * @return the boolean
     */
    public static boolean openUrl(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open map in a map app
     *
     * @param context the context
     * @param parh    the parh
     * @return the boolean
     */
    public static boolean openMap(Context context, String parh) {
        Uri uri = Uri.parse(parh);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open dial
     *
     * @param context the context
     * @return the boolean
     */
    public static boolean openDial(Context context) {
        Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open dial with a number
     *
     * @param context the context
     * @param number  the number
     * @return the boolean
     */
    public static boolean openDial(Context context, String number) {
        Uri uri = Uri.parse("tel:" + number);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Call up, requires Permission "android.permission.CALL_PHONE"
     *
     * @param context the context
     * @param number  the number
     * @return the boolean
     */
    @SuppressWarnings("MissingPermission")
    public static boolean call(Context context, String number) {
        Uri uri = Uri.parse("tel:" + number);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Send message
     *
     * @param context     the context
     * @param sendNo      the send no
     * @param sendContent the send content
     * @return the boolean
     */
    public static boolean sendMessage(Context context, String sendNo, String sendContent) {
        Uri uri = Uri.parse("smsto:" + sendNo);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", sendContent);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open contact person
     *
     * @param context the context
     * @return the boolean
     */
    public static boolean openContacts(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Open system settings
     *
     * @param context the context
     * @return the boolean
     */
    public static boolean openSettings(Context context) {
        return openSettings(context, Settings.ACTION_SETTINGS);
    }

    /**
     * Open system settings
     *
     * @param context the context
     * @param action  The action contains global system-level device preferences.
     * @return the boolean
     */
    public static boolean openSettings(Context context, String action) {
        if (!StringUtils.isEmpty(action)) {
            Intent intent = new Intent(action);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
        } else {
            return openSettings(context);
        }
        return false;
    }

    /**
     * Open camera
     *
     * @param context the context
     * @return the boolean
     */
    public static boolean openCamera(Context context) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * Take camera, this photo data will be returned in onActivityResult()
     *
     * @param activity    the activity
     * @param requestCode the request code
     * @return the boolean
     */
    public static boolean takeCamera(Activity activity, int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, requestCode);
            return true;
        }
        return false;
    }

    /**
     * Choose photo, this photo data will be returned in onActivityResult()
     *
     * @param activity    the activity
     * @param requestCode the request code
     * @return the boolean
     */
    public static boolean choosePhoto(Activity activity, int requestCode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, requestCode);
            return true;
        }
        return false;

    }

}
