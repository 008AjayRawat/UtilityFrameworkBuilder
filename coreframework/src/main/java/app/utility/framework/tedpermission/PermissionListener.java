package app.utility.framework.tedpermission;

import java.util.List;

public interface PermissionListener {

  void onPermissionGranted();

  void onPermissionDenied(List<String> deniedPermissions);

}
