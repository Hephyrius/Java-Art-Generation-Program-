#
# "$Id: Makefile 1694 2011-12-29 05:59:47Z mike $"
#
#   JPEG library Makefile for the HTMLDOC software.
#
#   Copyright 2011 by Michael R Sweet.
#   Copyright 1997-2010 by Easy Software Products.
#
#   This program is free software.  Distribution and use rights are outlined in
#   the file "COPYING.txt".
#

include ../Makedefs

#
# Object files...
#

OBJS	=	\
		jaricom.o \
		jcapimin.o \
		jcapistd.o \
		jcarith.o \
		jccoefct.o \
		jccolor.o \
		jcdctmgr.o \
		jchuff.o \
		jcinit.o \
		jcmainct.o \
		jcmarker.o \
		jcmaster.o \
		jcomapi.o \
		jcparam.o \
		jcprepct.o \
		jcsample.o \
		jctrans.o \
		jdapimin.o \
		jdapistd.o \
		jdarith.o \
		jdatadst.o \
		jdatasrc.o \
		jdcoefct.o \
		jdcolor.o \
		jddctmgr.o \
		jdhuff.o \
		jdinput.o \
		jdmainct.o \
		jdmarker.o \
		jdmaster.o \
		jdmerge.o \
		jdpostct.o \
		jdsample.o \
		jdtrans.o \
		jerror.o \
		jfdctflt.o \
		jfdctfst.o \
		jfdctint.o \
		jidctflt.o \
		jidctfst.o \
		jidctint.o \
		jmemmgr.o \
		jmemnobs.o \
		jquant1.o \
		jquant2.o \
		jutils.o


#
# Make all targets...
#

all:	libjpeg.a


#
# Clean all targets and object files...
#

clean:
	$(RM) $(OBJS)
	$(RM) libjpeg.a


#
# Update dependencies...
#

depend:
	makedepend -Y -I.. -fDependencies $(OBJS:.o=.c) >/dev/null 2>&1


#
# libjpeg.a
#

libjpeg.a:	$(OBJS)
	echo Archiving $@...
	$(RM) $@
	$(AR) $(ARFLAGS) $@ $(OBJS)
	$(RANLIB) $@

$(OBJS):	../Makedefs
include Dependencies


#
# End of "$Id: Makefile 1694 2011-12-29 05:59:47Z mike $".
#
