package com.example.dong.yomoo.http.handlers;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dong.yomoo.entitiy.BreedingInfo;
import com.example.dong.yomoo.entitiy.BreedingInfoDemand;
import com.example.dong.yomoo.entitiy.FodderOfVendor;
import com.example.dong.yomoo.entitiy.LivestockDemand;
import com.example.dong.yomoo.entitiy.Order;
import com.example.dong.yomoo.entitiy.Purchase;
import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.entitiy.users.User;
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

    /**
     * 发布养殖技术（饲料销售商）
     *
     * @param requestBean
     * @param callback
     */
    public void postBreedingInfo(RequestBean requestBean, final HttpCallback<BreedingInfo> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    BaseResult<BreedingInfo> result = new BaseResult<>();
                    result.setData(null);
                    result.setValue("");
                    result.setMessage(jsonObject.getString("message"));
                    result.setResultCode(jsonObject.getInt("code"));
                    callback.onSuccess(result);
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
     * 获取养殖技术列表（养殖户）
     *
     * @param requestBean
     * @param callback
     */
    public void getBreedingInfoList(RequestBean requestBean, final HttpCallback<List<BreedingInfo>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<BreedingInfo> breedingInfoList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<BreedingInfo>>() {
                                }.getType());
                        BaseResult<List<BreedingInfo>> result = new BaseResult<>();
                        result.setData(breedingInfoList);
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

    public void getBreedingInfoDetail(RequestBean requestBean, final HttpCallback<BreedingInfo> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BreedingInfo breedingInfo = gson.fromJson(data.getJSONObject("info").toString(),
                                new TypeToken<BreedingInfo>() {
                                }.getType());
                        BaseResult<BreedingInfo> result = new BaseResult<>();
                        result.setData(breedingInfo);
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
     * 发布牲畜需求信息（肉品加工商）
     *
     * @param requestBean
     * @param callback
     */
    public void postLivestockDemand(RequestBean requestBean, final HttpCallback<LivestockDemand> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    BaseResult<LivestockDemand> result = new BaseResult<>();
                    result.setData(null);
                    result.setValue("");
                    result.setMessage(jsonObject.getString("message"));
                    result.setResultCode(jsonObject.getInt("code"));
                    callback.onSuccess(result);
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

    public void postBreedingInfoDemand(RequestBean requestBean, final HttpCallback<BreedingInfoDemand> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    BaseResult<BreedingInfoDemand> result = new BaseResult<>();
                    result.setData(null);
                    result.setValue("");
                    result.setMessage(jsonObject.getString("message"));
                    result.setResultCode(jsonObject.getInt("code"));
                    callback.onSuccess(result);
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

    public void getFodderOfVendorListByVendor(RequestBean requestBean, final HttpCallback<List<FodderOfVendor>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<FodderOfVendor> fvList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<FodderOfVendor>>() {
                                }.getType());
                        BaseResult<List<FodderOfVendor>> result = new BaseResult<>();
                        result.setData(fvList);
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

    public void getHistoryOrderList(RequestBean requestBean, final HttpCallback<List<Order>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<Order> orderList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<Order>>() {
                                }.getType());
                        BaseResult<List<Order>> result = new BaseResult<>();
                        result.setData(orderList);
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

    public void getFodderDetail(RequestBean requestBean, final HttpCallback<FodderOfVendor> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        BaseResult<FodderOfVendor> result = new BaseResult<>();
                        FodderOfVendor fv = gson.fromJson(data.getJSONObject("fv").toString(), new TypeToken<FodderOfVendor>() {
                        }.getType());
                        result.setData(fv);
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

    public void postOrder(RequestBean requestBean, final HttpCallback<Order> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        Order order = gson.fromJson(data.getJSONObject("order").toString(),
                                new TypeToken<Order>() {
                                }.getType());
                        BaseResult<Order> result = new BaseResult<>();
                        result.setData(order);
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

    public void postPurchase(RequestBean requestBean, final HttpCallback<Purchase> callback) {
        volleyUtils.httpPostString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        Purchase purchase = gson.fromJson(data.getJSONObject("purchase").toString(),
                                new TypeToken<Purchase>() {
                                }.getType());
                        BaseResult<Purchase> result = new BaseResult<>();
                        result.setData(purchase);
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

    public void getPurchaseList(RequestBean requestBean, final HttpCallback<List<Purchase>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<Purchase> purchaseList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<Purchase>>() {
                                }.getType());
                        BaseResult<List<Purchase>> result = new BaseResult<>();
                        result.setData(purchaseList);
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

    /**
     * 获取已注册的养殖户列表
     *
     * @param requestBean
     * @param callback
     */
    public void getFarmerList(RequestBean requestBean, final HttpCallback<List<Farmer>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<Farmer> farmerList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<Farmer>>() {
                                }.getType());
                        BaseResult<List<Farmer>> result = new BaseResult<>();
                        result.setData(farmerList);
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

    /**
     * 获取肉品加工商的牲畜需求列表
     *
     * @param requestBean
     * @param callback
     */
    public void getLivestockDemandList(RequestBean requestBean, final HttpCallback<List<LivestockDemand>> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        int offset = data.getInt("offset");
                        List<LivestockDemand> demandList = gson.fromJson(data.getJSONArray("list").toString(),
                                new TypeToken<List<LivestockDemand>>() {
                                }.getType());
                        BaseResult<List<LivestockDemand>> result = new BaseResult<>();
                        result.setData(demandList);
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

    public void getLivestockDemandDetail(RequestBean requestBean, final HttpCallback<LivestockDemand> callback) {
        volleyUtils.httpGetString(requestBean, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == HttpAPI.RESULT_OK) {
                        Gson gson = new Gson();
                        JSONObject data = jsonObject.getJSONObject("data");
                        LivestockDemand demand = gson.fromJson(data.getJSONObject("livestock_demand").toString(),
                                new TypeToken<LivestockDemand>() {
                                }.getType());
                        BaseResult<LivestockDemand> result = new BaseResult<>();
                        result.setData(demand);
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
