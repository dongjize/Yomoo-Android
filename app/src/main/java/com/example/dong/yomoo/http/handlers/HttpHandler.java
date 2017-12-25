package com.example.dong.yomoo.http.handlers;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dong.yomoo.entities.users.Farmer;
import com.example.dong.yomoo.entities.users.User;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 网络请求者
 */
public class HttpHandler extends BaseHttpHandler {

    public HttpHandler(Context context) {
        super(context);
    }

    public void startup(RequestBean requestBean, HttpCallback callback) {

    }

    /**
     * 用户注册
     *
     * @param requestBean
     * @param callback
     */
    public void userRegister(RequestBean requestBean, final HttpCallback<User> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BaseResult<User> result = new BaseResult<>();
                        boolean isFarmer = data.getBoolean("is_farmer");

                        if (isFarmer) {
                            Farmer farmer = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<Farmer>() {
                            }.getType());
                            result.setData(farmer);
                        } else {
                            User user = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<User>() {
                            }.getType());
                            result.setData(user);
                        }

                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }

    public void userCompleteInfo(RequestBean requestBean, final HttpCallback<User> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BaseResult<User> result = new BaseResult<>();
                        boolean isFarmer = data.getBoolean("is_farmer");

                        if (isFarmer) {
                            Farmer farmer = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<Farmer>() {
                            }.getType());
                            result.setData(farmer);
                        } else {
                            User user = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<User>() {
                            }.getType());
                            result.setData(user);
                        }

                        result.setValue("");
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }

    /**
     * 用户登录
     *
     * @param requestBean
     * @param callback
     */
    public void userLogin(RequestBean requestBean, final HttpCallback<User> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BaseResult<User> result = new BaseResult<>();
                        boolean isFarmer = data.getBoolean("is_farmer");

                        if (isFarmer) {
                            Farmer farmer = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<Farmer>() {
                            }.getType());
                            result.setData(farmer);
                        } else {
                            User user = gson.fromJson(data.getJSONObject("user").toString(), new TypeToken<User>() {
                            }.getType());
                            result.setData(user);
                        }

                        result.setValue("");
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }


    /**
     * 用户退出登录
     *
     * @param requestBean
     * @param callback
     */
    public void userLogout(RequestBean requestBean, final HttpCallback callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        BaseResult result = new BaseResult();
                        result.setData(null);
                        result.setValue("");
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }


    /**
     * 获取养殖户列表
     *
     * @param requestBean
     * @param callback
     */
    public void getFarmerInfo(RequestBean requestBean, final HttpCallback<Farmer> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BaseResult<Farmer> result = new BaseResult<>();
                        Farmer farmer = gson.fromJson(data.getJSONObject("farmer").toString(), new TypeToken<Farmer>() {
                        }.getType());
                        result.setData(farmer);
                        result.setValue("");
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }

                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }


    /**
     * 获取用户列表
     *
     * @param requestBean
     * @param callback
     */
    public void getUserList(RequestBean requestBean, final HttpCallback<List<User>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<User> users = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<User>>() {
                                }.getType());
                        BaseResult<List<User>> result = new BaseResult<>();
                        result.setData(users);
                        result.setValue(offset + "");
                        result.setMessage(jsonObject.getString("message"));
                        result.setResultCode(jsonObject.getInt("code"));
                        callback.onSuccess(result);
                    } else {
                        callback.onFailure(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onFailure(e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
    }

}
