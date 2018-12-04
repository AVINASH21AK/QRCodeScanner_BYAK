package com.qrcodescanner.utils;

/**
 * Created by avinash.kahar on 9/17/2018.
 */

public class Constants {


    public static class APP_MODE{
        public static String Production = "1";
        public static String Development = "2";
    }


    public static class INTENT{
        public static String From = "from";
        public static String QRCode_ScanResult = "ScanResult";
    }

    public static class SHAREDPREFERENCE{

        public static class API{
            public static String DeviceId = "device_id";   //IMEI
            public static String AndroidToken = "androidtoken";  //push notification device id
            public static String AccessToken = "accesstoken";  //which you get frm login, sociallogin register api
        }

        public static class USER{
            public static String Login = "isLogin";   //0-notLogin & 1-Login
            public static String ID = "ID";
            public static String Emailid = "Emailid";
            public static String FirstName = "FirstName";
            public static String LastName = "LastName";
        }
    }


    //-- Google Analytics Screen Name
    public static class GAI{
        public static String SideMenu = "SideMenu";
        public static String NotificationListing = "Notifications";
    }


    public static class MESSAGES{

        public static class ERROR{
            public static String Unknown = "Oops, something went wrong. Please try again later";
            public static String NoInternetConnection = "You do not seem to have a strong Internet connection. Kindly move to a WiFi or stronger cellular signal";
        }

        public static class VALIDATIONS{
            public static String Name = "Please enter name.";
            public static String Email = "Please enter email id.";
            public static String EmailInvalid = "Please enter valid email id.";
            public static String Password = "Please enter password.";
        }

        public static class API{
            public static String SocialLogin_AccountAlreadyRegistered = "Seems your account is not registered yet, would you like to register?";
        }
    }


}
