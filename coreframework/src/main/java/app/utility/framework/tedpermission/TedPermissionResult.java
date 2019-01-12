package app.utility.framework.tedpermission;


import java.util.List;

import app.utility.framework.tedpermission.util.ObjectUtils;

public class TedPermissionResult {

  private boolean granted;
  private List<String> deniedPermissions;

  public TedPermissionResult(List<String> deniedPermissions) {
    this.granted = ObjectUtils.isEmpty(deniedPermissions);
    this.deniedPermissions = deniedPermissions;
  }

  public boolean isGranted() {
    return granted;
  }

  public List<String> getDeniedPermissions() {
    return deniedPermissions;
  }
}
