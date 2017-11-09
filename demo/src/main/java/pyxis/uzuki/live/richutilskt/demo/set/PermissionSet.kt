package pyxis.uzuki.live.richutilskt.demo.set

import android.Manifest
import android.content.Context
import android.text.TextUtils
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.RPermission
import pyxis.uzuki.live.richutilskt.utils.alert

/**
 * RichUtilsKt
 * Class: PermissionSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getPermissionSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val checkPermission = generateExecuteItem(CategoryItem.PERMISSION, "checkPermission",
            "check and request Permission which given.",
            "RPermission.instance.checkPermission(this, array = arrays, callback = { _: Int, _: List<String> ->\n" +
                    "})",
            "RPermission.instance.checkPermission(this, arrays, (integer, strings) -> {\n" +
                    "});") {
        val arrays: Array<String> = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA)
        RPermission.instance.checkPermission(this, array = arrays, callback = { resultCode: Int, list: List<String> ->
            alert(message = "Permission result -> $resultCode / Requested Permission: ${TextUtils.join(",", list)}")
        })
    }

    list.add(checkPermission)

    return list
}