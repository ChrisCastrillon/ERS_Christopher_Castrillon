package com.revature.templates;

public class ReimbursementUpdateTemplate {
    private String reimbId;
    private String resolver;
    private String statusId;

    
    public ReimbursementUpdateTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }


    public ReimbursementUpdateTemplate(String reimbId, String resolver, String statusId) {
        super();
        this.reimbId = reimbId;
        this.resolver = resolver;
        this.statusId = statusId;
    }


    public String getReimbId() {
        return reimbId;
    }


    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }


    public String getResolver() {
        return resolver;
    }


    public void setResolver(String resolver) {
        this.resolver = resolver;
    }


    public String getStatusId() {
        return statusId;
    }


    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reimbId == null) ? 0 : reimbId.hashCode());
        result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
        result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReimbursementUpdateTemplate)) {
            return false;
        }
        ReimbursementUpdateTemplate other = (ReimbursementUpdateTemplate) obj;
        if (reimbId == null) {
            if (other.reimbId != null) {
                return false;
            }
        } else if (!reimbId.equals(other.reimbId)) {
            return false;
        }
        if (resolver == null) {
            if (other.resolver != null) {
                return false;
            }
        } else if (!resolver.equals(other.resolver)) {
            return false;
        }
        if (statusId == null) {
            if (other.statusId != null) {
                return false;
            }
        } else if (!statusId.equals(other.statusId)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "ReimbursementUpdateTemplate [reimbId=" + reimbId + ", resolver=" + resolver + ", statusId=" + statusId
                + "]";
    }
    
}
