package org.coolnimesh.a360.pojo;

import java.util.List;

public class BucketResponse {

    private String key;
    private String owner;
    private String createDate;
    List<Permission> permissions;
    private String policyKey;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getPolicyKey() {
        return policyKey;
    }

    public void setPolicyKey(String policyKey) {
        this.policyKey = policyKey;
    }

    @Override
    public String toString() {
        return "BucketResponse [key=" + key + ", owner=" + owner + ", createDate=" + createDate + ", permissions=" + permissions
                + ", policyKey=" + policyKey + "]";
    }

    public static class Permission {
        private String serviceId;
        private String access;

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getAccess() {
            return access;
        }

        public void setAccess(String access) {
            this.access = access;
        }

        @Override
        public String toString() {
            return "Permission [serviceId=" + serviceId + ", access=" + access + "]";
        }

    }

}
