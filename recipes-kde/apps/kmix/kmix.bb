SUMMARY = "KDE's audio mixer"
LICENSE = "GPLv2 & GFDL-1.2 & LGPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.DOC;md5=24ea4c7092233849b4394699333b5c56 \
    file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
"

inherit kde-apps gettext

DEPENDS += " \
    alsa-lib \
    libcanberra \
    \
    kauth-native \
    kconfig-native \
    kcoreaddons-native \
    kconfigwidgets \
    kpackage-native \
    kdesignerplugin-native \
    sonnet-native \
    kdbusaddons \
    kdelibs4support \
    kdelibs4support-native \
    kglobalaccel \
    ki18n \
    kiconthemes \
    kxmlgui \
    plasma-framework \
"

PACKAGECONFIG = "pulseaudio"    
PACKAGECONFIG[pulseaudio] = ",,pulseaudio"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "ebcbaee05b665aab2a16c21f820ec887"
SRC_URI[sha256sum] = "066f71e6a47bae97397a5d90569ac130173282d5780a0f708b015f604cff8de5"

SRC_URI += "file://0001-Fix-build-with-QT_NO_SESSIONMANAGER-set.patch"

EXTRA_OECMAKE += "-DKMIX_KF5_BUILD=1"

FILES_SOLIBSDEV = ""

FILES_${PN} += " \
    ${datadir}/k*5 \
    ${datadir}/plasma \
    ${datadir}/icons \
    ${datadir}/dbus-1 \
    \
    ${libdir}/libkdeinit5*.so \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/plasma/*/.debug \
"
