SUMMARY = "Resource and network access abstraction"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5 gettext mime-xdg

DEPENDS += " \
    qttools-native \
    karchive \
    kcodecs \
    kconfig-native \
    kcoreaddons-native \
    kdbusaddons \
    kdoctools-native \
    ki18n \
    knotifications \
    kservice \
    solid \
    kxmlgui \
    kwallet \
    kauth-native \
    sonnet-native \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/libx11", "", d)} \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "f9922ca3460cf47c502ffe4cfd938410"
SRC_URI[sha256sum] = "0ab32bff63f542598e95be64a793eefe8f51b041fbb447256a4aa1c756214ba2"

SRC_URI += "file://0001-Extend-upstream-workaround-for-bug-371721-to-also-co.patch"

PACKAGECONFIG[full] = "-DKIOCORE_ONLY=OFF,-DKIOCORE_ONLY=ON, kbookmarks kcompletion kconfigwidgets kiconthemes kitemviews kjobwidgets kwidgetsaddons kwindowsystem"
# Note that kdeclarative fails without KIOWidgets
PACKAGECONFIG ??= "full"

# REVISIT make optional
DEPENDS += " \
    krb5 \
"

do_configure_append() {
    # fix sysroot path
    sed -i 's:${STAGING_BINDIR_NATIVE}:${bindir}:g' ${B}/src/ioslaves/help/config-help.h
}

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/k*5 \
    ${datadir}/polkit-1 \
    ${datadir}/kconf_update \
    ${OE_QMAKE_PATH_PLUGINS} \
"
