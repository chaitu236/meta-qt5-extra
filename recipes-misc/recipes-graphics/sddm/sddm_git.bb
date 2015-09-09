SUMMARY = "SDDM is a modern display manager for X11"
LICENSE = "GPLv2 & CC-BY-3.0 & CC-BY-NC-SA-3.0"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING-CC-BY-3.0;md5=3f91257948001a369d427b9028de84b2 \
    file://COPYING-CC-BY-SA-3.0;md5=c0e44077d8998dd1cd1324f7bc4d7b67 \
"

REQUIRED_DISTRO_FEATURES = "x11"

inherit cmake_qt5 cmake-extra-sanity pkgconfig systemd useradd distro_features_check

DEPENDS += "qtbase qtdeclarative qttools-native libxcb"
# REVISIT optionals
DEPENDS += "libpam"

SRC_URI = " \
    git://github.com/sddm/${BPN}.git;protocol=git;branch=master \
    file://0001-fix-qml-install-dir.patch \
    file://sddm.pam \
    file://sddm.conf \
"
SRCREV = "79f8a58f7fed3a9033b71f8893fb182df38a6210"
PV = "0.12.0"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DQML_INSTALL_DIR=${OE_QMAKE_PATH_QML}"

do_configure_append() {
    # fix sysroot path
    sed -i 's:${STAGING_DIR_NATIVE}.*${libdir}:${libdir}:g' ${B}/src/common/Constants.h
}

do_install_append() {
    install -d ${D}/${sysconfdir}
    install -m 644 ${WORKDIR}/sddm.conf ${D}/${sysconfdir}

    install -d ${D}${sysconfdir}/pam.d
    install -m 644 ${WORKDIR}/sddm.pam ${D}${sysconfdir}/pam.d/sddm

    install -d ${D}${localstatedir}/lib/sddm
    chown -R sddm:sddm ${D}${localstatedir}/lib/sddm
    chmod 0750 ${D}${localstatedir}/lib/sddm
}

FILES_${PN} += "${OE_QMAKE_PATH_QML}"

SYSTEMD_SERVICE_${PN} = "${BPN}.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --home ${localstatedir}/lib/sddm --shell /bin/false --user-group --groups video sddm"

RDEPENDS_${PN} += " \
    qtbase-plugins \
    qtbase-fonts \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
"
