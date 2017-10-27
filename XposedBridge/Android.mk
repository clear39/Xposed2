LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := XposedBridge

#LOCAL_MODULE_OWNER := 


LOCAL_SRC_FILE := \
	$(call all-java-files-under , src) \
	$(call all-java-files-under , lib/apache-commons-lang/external) \
	$(call all-java-files-under , HiddenAPIStubs/src) 


include $(BUILD_JAVA_LIBRARY)



$(LOCAL_INTERMEDIATE_TARGETS): PRIVATE_EXTRA_JAR_ARGS := -C "$(LOCAL_PATH)" assests -C "$(LOCAL_PATH)" NOTICE.txt

include $(call all-makefiles-under , $(LOCAL_PATH))
