SUMMARY = "aubio is designed for the extraction of annotations from audio signals"
HOMEPAGE = "https://aubio.org/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf pkgconfig

DEPENDS += " \
    jack \
    ffmpeg \
    libsndfile1 \
    libsamplerate0 \
    python3-numpy \
"

SRC_URI = " \
    https://aubio.org/pub/${BPN}-${PV}.tar.bz2 \
    file://0001-do-not-build-tests.patch \
    file://0002-Fix-build-with-FFmpeg-4.0.patch \
"
SRC_URI[md5sum] = "78d326e5e44d19b0d21a5abf834bae20"
SRC_URI[sha256sum] = "bdc73be1f007218d3ea6d2a503b38a217815a0e2ccc4ed441f6e850ed5d47cfb"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --sysconfdir=${sysconfdir} \
    --libdir=${libdir} \
"
